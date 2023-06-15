import { Component } from '@angular/core';

@Component({
  selector: 'app-item-recommend',
  templateUrl: './item-recommend.component.html',
  styleUrls: ['./item-recommend.component.scss']
})
export class ItemRecommendComponent {
  displayedColumns: string[] = ['item class', 'prefixes', 'suffixes'];
  itemClasses: string[] = ['quiver', 'amulet', 'ring1', 'ring2', 'belt', 'shield', 'helmet', 'boots', 'gloves']
  // @ts-ignore
  dataSource = JSON.parse(localStorage.getItem('items'));

  constructor() {
    }
}
