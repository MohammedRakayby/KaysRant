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
  removePost(id: number) {
    this.posts = this.posts.filter(post => post.id !== id);
  }

  findPost(id: number | string) {
    return this._posts.pipe(
      map((posts: Post[]) => 
        posts.find(post => {
          post.id === +id || post.slug === id
        }))
    )
  }
}
