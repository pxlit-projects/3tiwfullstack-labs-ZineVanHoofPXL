import { Component, Input } from '@angular/core';
import { Customer } from '../../../shared/models/customer.model';
import { NgClass } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-customer-item',
  standalone: true,
  imports: [NgClass, RouterLink],
  templateUrl: './customer-item.component.html',
})
export class CustomerItemComponent {
  @Input() customer!: Customer;

  getDetails(): void {
    console.log(this.customer);
  }
}
