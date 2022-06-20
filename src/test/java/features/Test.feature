Feature: Amaozon
  Scenario Outline:
    Given sheetname "<SheetName>" and rownumber "<RowNumber>"
    Examples:
      |SheetName|RowNumber|
      |contactus|0|
      |contactus|1|