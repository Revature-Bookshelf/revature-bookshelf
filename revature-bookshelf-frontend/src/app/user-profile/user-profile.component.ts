import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';



@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})

export class UserProfileComponent implements OnInit {
  profileForm = this.fb.group({
    firstName: ['', Validators.required],
    middleName: ['', Validators.required],
    lastName: ['', Validators.required],
    email: ['', Validators.required],
  });


  email: string | null = null
  // currentUser: Object = {};
    currentUser: any = {}
    addresses: any = {}

  constructor(
    public userService: UserService,
    private actRoute: ActivatedRoute,
    private fb: FormBuilder
  ) 
  
  {
    // let id = this.actRoute.snapshot.paramMap.get('id');
    //   this.userService.getUserProfile(id).subscribe(res => {
    //   this.currentUser = res.msg;
    // })
  }

  updateProfile(){
    console.log(this.profileForm.value)
  }


  ngOnInit() {
    this.userService.decodeToken();
    this.email = this.userService.userName;
    this.userService
          .getUser()
          .subscribe(user => this.currentUser = user);

    // HARD ENCODED ADDRESSES
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
  }      


}
