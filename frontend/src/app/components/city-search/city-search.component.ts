import {Component, OnInit} from '@angular/core';
import {WeatherService} from '../../weather.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Observable} from 'rxjs';
import cityList from '../../../assets/city.list.json';
import {map, startWith} from 'rxjs/operators';

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

  constructor(private service: WeatherService) {
  }

  ngOnInit(): void {

    this.filteredCities =
      this.searchControl.valueChanges.pipe(
        startWith(''),
        map(value => this._filter(value))
      );
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
    console.log('City has been selected ' +  selectedCity);
  }

  addCity(): void {
    this.selectedCity = '';
  }
}
