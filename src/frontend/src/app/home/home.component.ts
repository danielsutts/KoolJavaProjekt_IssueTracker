import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username: any = "";

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<any>('/issues/all').subscribe(res => {
      if (res) {
        console.log('List: ', res);
      } else {
        alert('Failed to query list.')
      }
    })
    this.http.get('/api/user/me').subscribe(res => {
      if (res) {
        this.username = res;
      }
    });
  }

}
