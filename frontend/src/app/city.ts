import {WeatherCode} from './weather-code';

export interface City {
  cityName: string;
  country: string;
  temperature: bigint;
  weatherCode: WeatherCode;
}
