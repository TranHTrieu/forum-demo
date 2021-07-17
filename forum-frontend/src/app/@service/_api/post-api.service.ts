import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Post} from "../../@model/post.model";

@Injectable({providedIn: 'root'})
export class PostApiService {
  private baseUrl: string = 'http://localhost:8080/api/posts';

  constructor(private http: HttpClient) {}

  getPosts(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  addPost(post: Post): Observable<any> {
    return this.http.post(`${this.baseUrl}`, post);
  }

  getCommentsFromPost(postId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
