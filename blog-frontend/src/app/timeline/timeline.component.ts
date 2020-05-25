import { Component, OnInit } from '@angular/core';
import { HttpService } from '../services/httpservice/http.service';
import { Post } from '../models/post.model';
import { Controllers, Endpoints } from '../defines/api.endpoints';


@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {

  viewAll: boolean;
  postsArr: Post[];
  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.viewAll = true;
    this.getAllArticles();
  }
  getAllArticles() {
    let url = Controllers.POST + Endpoints.GET_ALL;
    this.httpService.getData(url).subscribe((posts: any) => { console.log(posts); this.postsArr = posts });
    console.log(this.postsArr);
  }
  openPost(id: number) {
    this.viewAll = false;
  }
}
