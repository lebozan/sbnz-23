import { Component, OnInit } from '@angular/core';
import {SkillGem} from "../../model/skill-gem";
import {AllDataService} from "../../service/all-data.service";
import {FormBuilder} from "@angular/forms";
import {Keystone} from "../../model/keystone";


@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {
  activeGems: Array<SkillGem>;
  supportGems: Array<SkillGem>;
  keystones: Array<Keystone>;
  selectedTab: number;

  constructor(
    private dataService: AllDataService,
  ) {
    this.activeGems = [];
    this.supportGems = [];
    this.keystones = [];
    this.selectedTab = 0;
  }

  ngOnInit(): void {
    this.dataService.getAllActiveGems().subscribe(
      result => {
        if (result !== null) {
          this.activeGems = result;
        }
        console.log(result);
      }, error => {
        console.log(error);
      }
    );

    this.dataService.getAllSupportGems().subscribe(
      result => {
        if (result !== null) {
          this.supportGems = result;
        }
        console.log(result);
      }, error => {
        console.log(error);
      }
    );

    this.dataService.getAllKeystones().subscribe(
      result => {
        if (result !== null) {
          this.keystones = result;
        }
        console.log(result);
      }, error => {
        console.log(error);
      }
    );
  }

  firstEntrySubmited(changeTab: boolean): void {
    if (changeTab) {
      this.selectedTab = 1;
    }
  }
}
