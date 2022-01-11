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
  addresses: any = {}
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
    // toBeLoaded From DB
    this.addresses = [
      {
          "id": 2,
          "streetName": "3301 4th Ave S",
          "city": "Seattle",
          "state": "Washington",
          "postalCode": 98134,
          "types": [
              {
                  "id": 2,
                  "type": "BILLING"
              }
          ]
      },
      {
          "id": 1,
          "streetName": "6305 Martin Luther King Jr Way",
          "city": "Seattle",
          "state": "Washington",
          "postalCode": 98118,
          "types": [
              {
                  "id": 2,
                  "type": "BILLING"
              },
              {
                  "id": 1,
                  "type": "SHIPPING"
              }
          ]
      }
  ]
    this.actRoute.paramMap.subscribe(paramMap => {
       console.log(paramMap.get('token'));
    });
 }

}
