{
  "Actions" : [
    {
      "If" : {
        "Left" : {
          "ReadContext" : {
            "Value" : "ContextVar1"
          }
        },
        "Condition" : "Equal",
        "Right" : {
          "Use" : {
            "Value" : "1"
          }
        },
        "Then" : {
          "SetContext" : {
            "Name" : "Result",
            "Value" : "Success"
          }
        },
        "Else" : {
          "SetContext" : {
            "Name" : "Result",
            "Value" : "Failure"
          }
        }
      }
    }
  ]
}
