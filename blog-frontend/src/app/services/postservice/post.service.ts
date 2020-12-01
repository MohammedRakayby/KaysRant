import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Post } from 'src/app/models/post.model';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  constructor() { }
  private readonly _posts = new BehaviorSubject<Post[]>([]);
  private lastEvaluatedKey=new Map<String,String>();
  readonly posts$ = this._posts.asObservable();

  getPosts() {
    return this.posts;
  }

  private get posts(): Post[] {
    return this._posts.getValue();
  }

  private set posts(val: Post[]) {
    this._posts.next(val);
  }

  addPost(newPost: Post) {
    this.posts = [
      ...this.posts,
      newPost
    ];
  }
  replacePosts(posts:Post[]){
    this.posts=posts;
  }
  removePost(id: string) {
    this.posts = this.posts.filter(post => post.id !== id);
  }

  findPost(slug: string) {
    // return this._posts.pipe(
    //   map((posts: Post[]) => 
    //     posts.find(post => {
    //       post.id === id 
    //     }))
    // )
    return this.posts.find(post => post.slug===slug);
  }

  setLastEvaluatedKey(key){
    this.lastEvaluatedKey=key;
  }
  getLastEvaluatedKey():Map<String,String>{
    return this.lastEvaluatedKey;
  }
}
