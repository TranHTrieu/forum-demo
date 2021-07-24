import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Comment} from "../../@model/comment.model";
import {Observable} from "rxjs";

@Injectable({providedIn: 'root'})
export class CommentApiService {
  private baseUrl: string = 'http://localhost:8080/api/comments';

  constructor(private http: HttpClient) {}

  getCommentsByPostId(postId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/post/${postId}`);
  }

  addComment(comment: Comment, postId: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/post/${postId}`, comment);
  }
}
