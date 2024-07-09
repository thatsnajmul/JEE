import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit {
  item: any = {};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private itemService: ItemService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      const itemId = +id;
      console.log('Fetched ID:', itemId);
      this.itemService.getItem(itemId).subscribe(
        data => {
          this.item = data;
        },
        error => {
          console.error('Error fetching item:', error);
        }
      );
    } else {
      console.error('ID is null');
    }
  }

  updateItem(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      const itemId = +id;
      this.itemService.updateItem(itemId, this.item).subscribe(
        () => {
          this.router.navigate(['/items']);
        },
        error => {
          console.error('Error updating item:', error);
        }
      );
    } else {
      console.error('ID is null');
    }
  }
}


