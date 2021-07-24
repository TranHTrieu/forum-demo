import {Injectable} from "@angular/core";
import {BehaviorSubject} from "rxjs";

@Injectable({providedIn: 'root'})
export class PostStoreService {
  updateStatus: boolean = false;
  updateStatusChanged: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(this.updateStatus);

  setUpdateStatus() {
    this.updateStatus = true;
    this.updateStatusChanged.next(this.updateStatus);
    this.updateStatus = false;
  }
}
