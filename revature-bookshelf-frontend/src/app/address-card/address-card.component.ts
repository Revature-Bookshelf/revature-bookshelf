import { Component, Input, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import { AddressService } from '../address.service';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';


@Component({
  selector: 'app-address-card',
  templateUrl: './address-card.component.html',
  styleUrls: ['./address-card.component.scss']
})
export class AddressCardComponent implements OnInit {

  addressForm = this.fb.group({
    streetName: ['', Validators.required],
    city: ['', Validators.required],
    state: ['', Validators.required],
    postalCode: ['', Validators.required],
  });
  
  // address: Array<any>=[]

  @Input("addressInput") address: any = {};

  constructor(
    private addressService: AddressService,
    private fb: FormBuilder
  ) { }

  updateAddress(){
    console.log(this.addressForm.value)
  }


  addAddress() {
    let formData = this.addressForm.value;
    this.addressService.addAddress(formData);    
    console.log(formData)
  }


  ngOnInit(): void {
    this.addressService.getAddress()

    this.addressService.addressStream
    .subscribe({
      next:(e:any)=>{ 
        let {action,address}=e;
        this.address= address;
      }
    })

  }

}
