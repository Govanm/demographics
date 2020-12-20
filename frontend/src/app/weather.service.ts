import {City} from './city';
import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, retry, tap} from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class WeatherService {

  constructor(private http: HttpClient) {
  }

  getWeatherForCity(selectedCity: string): Observable<City> {
    const options = selectedCity.trim() ?
      {params: new HttpParams().set('city', selectedCity)} : {};
    return this.http.get<City>('http://localhost:8080/demographics', options).pipe(
      tap((newCity: City) => console.log(`added city =${newCity.cityName} with temperature=${newCity.temperature}`))
    );
  }
}
