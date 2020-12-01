import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators'
import { PostService } from '../services/postservice/post.service';
import { Post } from '../models/post.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-singlepost',
  templateUrl: './singlepost.component.html',
  styleUrls: ['./singlepost.component.css']
})
export class SinglepostComponent implements OnInit,OnDestroy {

  post: Post;
  constructor(private route: ActivatedRoute,
    private router: Router,
    private postService: PostService) { }
    private sub:any;
  ngOnDestroy(): void {
      this.sub.unsubscribe();
  }

  ngOnInit() {
    // this.post = this.route.paramMap.pipe(
    //   switchMap((params: ParamMap) => 
    //     this.postService.findPost(params.get('slug')))
    // );
    let slug;
    this.sub=this.route.params.subscribe(params=>{
      slug=params['slug'];
    })
    this.post=this.postService.findPost(slug);
  }

}
