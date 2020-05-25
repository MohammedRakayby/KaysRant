import { Component, OnInit } from '@angular/core';
import { Controllers, Endpoints } from '../defines/api.endpoints';
import { HttpService } from '../services/httpservice/http.service';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.httpService.login(undefined, undefined);
    // this.authenticate();
  }
  authenticate() {
    
  }

}
