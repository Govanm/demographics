import {City} from './city';
import {Injectable} from '@angular/core';

@Injectable({providedIn: 'root'})
export class WeatherService {
  private cities: City[];

  getWeatherForCity(selectedCity: string): void {

  }
}
