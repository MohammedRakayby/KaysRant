import { Component, OnInit } from '@angular/core';
import { Post } from '../models/post.model';
import { Controllers, Endpoints } from '../defines/api.endpoints';
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';


@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {
  postsArr: Post[];
  constructor(private httpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    withCredentials: true,
  };
  ngOnInit() {
    this.getAllArticles();
  }
  getAllArticles() {
    let url = "http://localhost:8080" + Controllers.POST + Endpoints.GET_ALL;
    this.httpClient.get(url).subscribe((posts: any) => { console.log(posts); this.postsArr = posts });
    console.log(this.postsArr);
  }

}
