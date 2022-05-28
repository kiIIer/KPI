import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '@auth0/auth0-angular';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css'],
})
export class ToolbarComponent implements OnInit {
  @Input() profile: User | null | undefined;
  @Input() loggedIn: boolean | null = false;
  @Output() goHomeEvent: EventEmitter<any> = new EventEmitter<any>();
  @Output() logInEvent: EventEmitter<any> = new EventEmitter<any>();
  @Output() logOutEvent: EventEmitter<any> = new EventEmitter<any>();
  @Output() searchEvent: EventEmitter<string> = new EventEmitter<string>();

  searchForm: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      ['q']: [null, Validators.required],
    });
  }

  goHome() {
    this.goHomeEvent.emit();
  }

  logIn() {
    this.logInEvent.emit();
  }

  logOut() {
    this.logOutEvent.emit();
  }

  search() {
    if (!this.searchForm.valid) {
      return;
    }
    let { q } = this.searchForm.value;
    console.log(q);
    this.searchEvent.emit(q as string);
  }
}
