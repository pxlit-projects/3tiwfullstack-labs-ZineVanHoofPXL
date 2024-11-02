import { Component, inject, OnInit } from '@angular/core';
import { CustomerItemComponent } from '../customer-item/customer-item.component';
import { FilterComponent } from '../filter/filter.component';
import { Customer } from '../../../shared/models/customer.model';
import { Filter } from '../../../shared/models/filter.model';
import { AddCustomerComponent } from '../add-customer/add-customer.component';
import { CustomerService } from '../../../shared/services/customer.service';

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CustomerItemComponent, FilterComponent, AddCustomerComponent],
  templateUrl: './customer-list.component.html',
})
export class CustomerListComponent implements OnInit {
  filteredData!: Customer[];
  customerService: CustomerService = inject(CustomerService);

  ngOnInit(): void {
    this.fetchData();
  }

  handleFilter(filter: Filter) {
    this.customerService.filterCustomers(filter).subscribe({
      next: (customers) => (this.filteredData = customers),
    });
  }

  fetchData(): void {
    this.customerService.getCustomers().subscribe({
      next: (customers) => {
        this.filteredData = customers;
      },
    });
  }
}
