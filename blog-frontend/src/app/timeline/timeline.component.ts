import { Component, OnInit } from '@angular/core';
import { Post } from '../models/post.model';
import { Controllers, Endpoints } from '../defines/api.endpoints';
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';
import { PostService } from '../services/postservice/post.service';
import { FetcherService } from '../services/fetcherservice/fetcher.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {
  private lastEvaluatedKey;
  postsArr$: Observable<Post[]>;
  constructor(private httpClient: HttpClient,
    private postService: PostService,
    private fetcherService:FetcherService) { }

  
  ngOnInit() {
    this.fetcherService.fetchAllPosts();
    this.postsArr$=this.postService.posts$;
  }

  
  // getAllArticles() {
  //   let url = "http://localhost:8080" + Controllers.POST + Endpoints.GET_ALL;
  //   this.httpClient.post(url, "{}", this.httpOptions).subscribe((postsPage: any) => {
  //     console.log("Page retrieved: " + JSON.stringify(postsPage));
  //     this.postsArr = postsPage.data.contentList;
  //     console.log("array: " + this.postsArr);
  //     this.lastEvaluatedKey = postsPage.data.lastEvaluatedKey
  //     console.log("lastEvaluatedKey: " + this.lastEvaluatedKey);
  //     this.setPostsInService();
  //   });
  // }
  // setPostsInService() {
  //   this.postsArr.forEach(
  //     (post:Post) => {
  //       this.postService.addPost(post);
  //     });
   
  // }

}
