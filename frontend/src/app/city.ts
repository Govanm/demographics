import {WeatherCode} from './weather-code';

export interface City {
  name: string;
  temperature: bigint;
  weatherCode: WeatherCode;
}
