export interface DimensionModel
{
  value: number | null,
  dimensions: Map<number, DimensionModel> | null,
  parameterName: string | null
}
