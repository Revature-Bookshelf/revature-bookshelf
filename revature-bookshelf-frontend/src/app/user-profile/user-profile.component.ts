import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';



@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})

export class UserProfileComponent implements OnInit {
  currentUser: Object = {};

  constructor(
    public userService: UserService,
    private actRoute: ActivatedRoute
  ) {
    let id = this.actRoute.snapshot.paramMap.get('id');
    console.log("this is my output:" + id)
    this.userService.getUserProfile(id).subscribe(res => {
      this.currentUser = res.msg;
    })
  }

  ngOnInit() {
    console.log(this.actRoute.snapshot.paramMap.get('token'));

    this.actRoute.paramMap.subscribe(paramMap => {
       console.log(paramMap.get('token'));
    });
 }

}
