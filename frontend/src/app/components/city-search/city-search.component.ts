import {Component, OnInit} from '@angular/core';
import {WeatherService} from '../../weather.service';
import {Observable} from 'rxjs';
import cityList from '../../../assets/city.list.json';
import {map, startWith} from 'rxjs/operators';
import {City} from '../../city';
import {FormControl} from '@angular/forms';
import {WeatherCode} from '../../weather-code';

@Component({
  selector: 'app-city-search',
  templateUrl: './city-search.component.html',
  styleUrls: ['./city-search.component.css']
})
export class CitySearchComponent implements OnInit {
  selectedCity = '';
  searchControl = new FormControl();
  filteredCities: Observable<string[]>;
  cities: string[] = cityList;
  searchResult: Array<City> = [];

  constructor(private weatherService: WeatherService) {
  }

  ngOnInit(): void {
    this.resetAutoComplete();
  }

  private _filter(selectedCityName: string): string[] {
    const filteredValue = this._normalizeValue(selectedCityName);
    return this.cities.sort().filter(city => this._normalizeValue(city).startsWith(filteredValue));
  }

  private _normalizeValue(selectedCityName: string): string {
    return selectedCityName.toLowerCase().replace(/\s/g, '');
  }

  selectCity(selectedCity: string): void {
    this.selectedCity = selectedCity;
    console.log('City has been selected ' + selectedCity);
  }

  addCity(): void {
    this.weatherService.getWeatherForCity(this.selectedCity).subscribe(newCity => {
        this.searchResult = this.searchResult.filter(city => newCity.cityName !== city.cityName);
        this.searchResult.push(newCity);
      }
    );
    this.selectedCity = '';
    this.resetAutoComplete();
  }

    private resetAutoComplete(): void {
    this.filteredCities =
      this.searchControl.valueChanges.pipe(
        startWith(''),
        map(value => this._filter(value))
      );
  }

  getIconName(weatherCode: number): string {
    const iconName = WeatherCode[weatherCode];
    if (iconName === undefined) {
      return 'na';
    }
    return iconName.toLowerCase();
  }

  delete(selectedCity: City): void {
    this.searchResult = this.searchResult.filter(city => selectedCity.cityName !== city.cityName);
  }

  getColor(weatherCode: number): string {
    const iconName = WeatherCode[weatherCode].toLowerCase();
    if (iconName.includes('sunny')) {
      return '#ccce5a';
    } else if (iconName.includes('cloud') || iconName.includes('overcast')) {
      return '#807f85';
    } else if (iconName.includes('rain') || iconName.includes('dizzle')) {
      return '#6bafe3';
    } else {
      return '#2c4370';
    }
  }
}
