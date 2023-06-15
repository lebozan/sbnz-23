import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {AllDataService} from "../../service/all-data.service";

@Component({
  selector: 'app-second-entry',
  templateUrl: './second-entry.component.html',
  styleUrls: ['./second-entry.component.scss']
})
export class SecondEntryComponent implements OnInit {

  @Output() changeTab = new EventEmitter<number>();
  selectedEquipment: Array<string>;
  isSelected: boolean;
  displayedColumns = ['name'];
  tableData: any;

  constructor(private dateService: AllDataService) {
    this.selectedEquipment = [];
    this.isSelected = false;
    this.tableData = new MatTableDataSource(this.selectedEquipment);
  }

  ngOnInit(): void {
  }


  selected(slot: string): void {

    this.isSelected = !this.isSelected;
    if (!this.selectedEquipment.includes(slot)) {
      this.selectedEquipment.push(slot);
    } else {
      this.selectedEquipment.splice(this.selectedEquipment.indexOf(slot), 1);
    }

    console.log(this.selectedEquipment);
  }

  sendSecondEntryData(): void {
    let buildString = localStorage.getItem("build")
    if (buildString !== null) {
      let build = JSON.parse(buildString)
      let data = {
        "buildId": build.id,
        "selectedEquipment": this.selectedEquipment
      }

      this.dateService.sendSecondEntry(data).subscribe({
        next: (response) => {
          // console.log("proso")
          console.log(response);
          localStorage.setItem("items", JSON.stringify( response))
          this.changeTab.emit(2);
        },
        error: (error) => {

        }
      })
    }

  }

}
