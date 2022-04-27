export interface DimensionModel
{
  value: number,
  dimensions: Map<number, DimensionModel>,
  parameterName: string
}
