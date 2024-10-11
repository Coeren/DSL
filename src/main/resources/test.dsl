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
          "If" : {
            "Left" : {
              "Use" : {
                "Value" : "22"
              }
            },
            "Condition" : "Less",
            "Right" : {
              "ReadContext" : {
                "Value" : "ContextVar2"
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
                "Value" : "Semifailure"
              }
            }
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
