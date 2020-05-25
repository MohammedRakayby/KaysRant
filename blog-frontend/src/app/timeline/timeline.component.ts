import { Component, OnInit } from '@angular/core';
import { HttpService } from '../services/httpservice/http.service';
import { Post } from '../models/post.model';
import { Controllers, Endpoints } from '../defines/api.endpoints';
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';


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
  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.faArrowLeft = faArrowLeft;
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
    let url = Controllers.POST + Endpoints.GET_POST + '?id=' + id;
    this.httpService.getData(url).subscribe((post: any) => {
      this.currentPostInView = post;
    });
  }
  handleBack() {
    this.viewAll = true;
  }
}
