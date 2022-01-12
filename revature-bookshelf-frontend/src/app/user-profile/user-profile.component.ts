import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { AddressService } from '../address.service';



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
    private userService: UserService,
    private actRoute: ActivatedRoute,
    private fb: FormBuilder,
    private addressService: AddressService
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


    this.addressService.getAddress();
    this.addressService.addressStream
      .subscribe({
        next: (e: any) => {
          let {action, addresses} = e;
          this.addresses = addresses;
          console.log(this.addresses)
        }
      })

  }      


}
