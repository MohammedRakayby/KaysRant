import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Controllers, Endpoints } from 'src/app/defines/api.endpoints';
import { PostService } from '../postservice/post.service';

@Injectable({
  providedIn: 'root'
})
export class FetcherService {

  constructor(private httpClient:HttpClient,
    private postService: PostService) { }
  
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  fetchAllPosts() {
    let url = "http://localhost:8080" + Controllers.POST + Endpoints.GET_ALL;
    console.log(this.postService.getLastEvaluatedKey());
    this.httpClient.post(url, this.postService.getLastEvaluatedKey(), this.httpOptions)
    .subscribe((postsPage: any) => {
      // console.log("Page retrieved: " + JSON.stringify(postsPage));
      this.postService.replacePosts(postsPage.data.contentList);
      this.postService.setLastEvaluatedKey(postsPage.data.lastEvaluatedKey);
      console.log("lastEvaluatedKey: " + postsPage.data.lastEvaluatedKey);
    });
  }
}
