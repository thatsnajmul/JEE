import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-item-add',
  templateUrl: './item-add.component.html',
  styleUrls: ['./item-add.component.css']
})
export class ItemAddComponent {
  item = { name: '', description: '' };

  constructor(private itemService: ItemService, private router: Router) {}

  addItem(): void {
    this.itemService.addItem(this.item).subscribe(() => {
      this.router.navigate(['/items']);
    });
  }
}

