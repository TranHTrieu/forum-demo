import {BehaviorSubject} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class CommentStoreService {
  updateStatus: boolean = false;
  updateStatusChanged: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(this.updateStatus);

  setUpdateStatus() {
    this.updateStatus = true;
    this.updateStatusChanged.next(this.updateStatus);
    this.updateStatus = false;
  }
}
