{
  "Rule" : {
    "Or" : { "Operands" : [
      {
        "In" : {
          "Parameter" : "PRODUCT_CODE",
          "List" : "PRODUCTS_SBK"
        }
      },
      {
        "In" : {
          "Parameter" : "KUO",
          "List" : "SBK_LEGACY"
        }
      },
      {
        "And" : { "Operands" : [
          {
            "NotIn" : {
              "Parameter" : "KUO",
              "Values" : [ "1234", "5678" ]
            }
          },
          {
            "Absent" : {
              "Parameter" : "PRODUCT_CODE"
            }
          }
        ] }
      }
    ] }
  }
}
