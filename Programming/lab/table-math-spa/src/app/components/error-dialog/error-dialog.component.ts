import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ErrorModel} from '../../models/Error.model';
import {FlatTreeControl} from '@angular/cdk/tree';
import {MatTreeFlatDataSource, MatTreeFlattener} from '@angular/material/tree';

interface ErrorFlatNode
{
  expandable: boolean;
  name: string;
  level: number;
}

@Component({
  selector: 'app-error-dialog',
  templateUrl: './error-dialog.component.html',
  styleUrls: ['./error-dialog.component.css'],
})
export class ErrorDialogComponent implements OnInit
{

  private _transformer = (node: ErrorModel, level: number) =>
  {
    return {
      expandable: !!node.subErrors && node.subErrors.length > 0,
      name: node.message,
      level: level,
    };
  };

  treeControl = new FlatTreeControl<ErrorFlatNode>(
    node => node.level,
    node => node.expandable,
  );

  treeFlattener = new MatTreeFlattener(
    this._transformer,
    node => node.level,
    node => node.expandable,
    node => node.subErrors,
  );

  dataSource = new MatTreeFlatDataSource(this.treeControl, this.treeFlattener);

  constructor(
    public dialogRef: MatDialogRef<ErrorDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ErrorModel,
  )
  {
    this.dataSource.data = [data];
  }

  onNoClick(): void
  {
    this.dialogRef.close();
  }

  ngOnInit(): void
  {
  }

  hasChild = (_: number, node: ErrorFlatNode) => node.expandable;
}
