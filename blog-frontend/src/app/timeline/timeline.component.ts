import { Component, OnInit } from '@angular/core';
import { Post } from '../models/post.model';
import { Controllers, Endpoints } from '../defines/api.endpoints';
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {
  faArrowLeft: any;
  viewAll: boolean;
  postsArr: Post[];
  currentPostInView: Post;
  constructor(private httpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
      // 'XSRF-TOKEN': this.xsrfToken
    }),
    withCredentials: true,
  };
  ngOnInit() {
    this.faArrowLeft = faArrowLeft;
    this.viewAll = true;
    this.getAllArticles();
  }
  getAllArticles() {
    let url = "http://localhost:8080" + Controllers.POST + Endpoints.GET_ALL;
    this.httpClient.get(url).subscribe((posts: any) => { console.log(posts); this.postsArr = posts });
    console.log(this.postsArr);
  }
  openPost(id: number) {
    this.viewAll = false;
    let url = Controllers.POST + Endpoints.GET_POST + '?id=' + id;
    this.httpClient.get(url).subscribe((post: any) => {
      this.currentPostInView = post;
    });
  }
  handleBack() {
    this.viewAll = true;
  }
}
