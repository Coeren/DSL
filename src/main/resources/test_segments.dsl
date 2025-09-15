{
  "Rule" : {
    "Or" : { "Operands" : [
      {
        "In" : {
          "Test" : { "Parameter" : { "Name" : "PRODUCT_CODE" } },
          "List" : "PRODUCTS_SBK"
        }
      },
      {
        "In" : {
          "Test" : { "Parameter" : { "Name" : "KUO" } },
          "List" : "SBK_LEGACY"
        }
      },
      {
        "And" : { "Operands" : [
          {
            "NotIn" : {
              "Test" : { "Parameter" : { "Name" : "KUO" } },
              "Values" : [ "1234", "5678" ]
            }
          },
          {
            "Absent" : {
              "Test" : { "Parameter" : { "Name" : "PRODUCT_CODE" } }
            }
          }
        ] }
      }
    ] }
  }
}
