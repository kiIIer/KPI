import {Component, EventEmitter, Inject, Input, OnInit, Output, SimpleChanges} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CalculateRequestModel} from '../../models/calculateRequest.model';
import {group} from '@angular/animations';
import {Parameter} from '@angular/compiler-cli/src/ngtsc/reflection';
import {ParameterModel} from '../../models/parameter.model';
import {ErrorModel} from '../../models/Error.model';
import {DimensionModel} from '../../models/dimension.model';
import {FlatTreeControl, NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeFlatDataSource, MatTreeFlattener, MatTreeNestedDataSource} from '@angular/material/tree';
import {TreeNodeModel} from '../../models/TreeNode.model';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ErrorDialogComponent} from '../error-dialog/error-dialog.component';

interface ResultFlatNode
{
  expandable: boolean;
  name: string | number;
  level: number;
}

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit
{
  @Output() loadResultEvent: EventEmitter<CalculateRequestModel> = new EventEmitter<CalculateRequestModel>();
  @Output() addParameterEvent: EventEmitter<string> = new EventEmitter<string>();
  @Output() deleteParameterEvent: EventEmitter<string> = new EventEmitter<string>();

  @Input() paramGroups: Map<string, FormGroup> | null = new Map<string, FormGroup>();

  @Input() set error(value: ErrorModel | null | undefined)
  {
    if (!!value)
    {
      this.openDialog(value!);
    }
  }

  @Input() set result(value: TreeNodeModel | null | undefined)
  {
    if (!!value)
    {
      this.dataSource.data = [value!];
    }
  }

  polishFormGroup: FormGroup = new FormGroup({polish: new FormControl('', [Validators.required])});
  addParameterFormGroup: FormGroup = new FormGroup({param: new FormControl('', [Validators.required])});

  private _transformer = (node: TreeNodeModel, level: number) =>
  {
    return {
      expandable: !!node.children && node.children.length > 0,
      name: node.name,
      level: level,
    };
  };

  treeControl = new FlatTreeControl<ResultFlatNode>(
    node => node.level,
    node => node.expandable,
  );

  treeFlattener = new MatTreeFlattener(
    this._transformer,
    node => node.level,
    node => node.expandable,
    node => node.children,
  );

  dataSource = new MatTreeFlatDataSource(this.treeControl, this.treeFlattener);


  constructor(
    private groupBuilder: FormBuilder,
    public dialog: MatDialog,
  )
  {
  }

  ngOnInit(): void
  {
  }

  openDialog(error: ErrorModel): void
  {
    console.log('opening dialog');
    this.dialog.open(ErrorDialogComponent, {
      data: error,
    });


  }

  addParameter()
  {
    if (!this.addParameterFormGroup.valid)
    {
      return;
    }

    let {param} = this.addParameterFormGroup.value;
    this.addParameterEvent.emit(param);
  }

  deleteParameter(id: string)
  {
    this.deleteParameterEvent.emit(id);
  }

  calculate()
  {
    if (!this.polishFormGroup.valid)
    {
      return;
    }

    this.paramGroups?.forEach((group: FormGroup) =>
    {
      if (!group.valid)
      {
        return;
      }
    });

    let calculateRequest: CalculateRequestModel = {
      parameters: [],
      polish: '',
    };

    calculateRequest.polish = this.polishFormGroup.value.polish;

    this.paramGroups?.forEach((group: FormGroup) =>
    {
      let parameter: ParameterModel;
      parameter = group.value;
      calculateRequest.parameters = [...calculateRequest.parameters, parameter];
    });

    this.loadResultEvent.emit(calculateRequest);
  }

  hasChild = (_: number, node: ResultFlatNode) => node.expandable;
}
