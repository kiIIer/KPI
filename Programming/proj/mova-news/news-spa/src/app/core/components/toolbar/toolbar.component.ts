import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css'],
})
export class ToolbarComponent implements OnInit {
  @Input() userName: string | undefined | null;
  @Input() isLogined: boolean | null = false;
  @Output() goHomeEvent: EventEmitter<any> = new EventEmitter<any>();
  @Output() logInEvent: EventEmitter<any> = new EventEmitter<any>();
  @Output() logOutEvent: EventEmitter<any> = new EventEmitter<any>();

  constructor() {}

  ngOnInit(): void {}

  goHome() {
    this.goHomeEvent.emit();
  }

  logIn() {
    this.logInEvent.emit();
  }

  logOut() {
    this.logOutEvent.emit();
  }
}
