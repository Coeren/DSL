{
  "Rule" : [
    {
      "If" : {
        "Left" : { "ReadContext" : { "Value" : "ContextVar1" } },
        "Condition" : "Equal",
        "Right" : { "Use" : { "Value" : "1" } },
        "Then" : {
          "If" : {
            "Left" : { "Use" : { "Value" : "22" } },
            "Condition" : "Less",
            "Right" : { "ReadContext" : { "Value" : "ContextVar2" } },
            "Then" : {
              "SetContext" : { "Name" : "Result", "Value" : "Success" }
            },
            "Else" : {
              "SetContext" : { "Name" : "Result", "Value" : "Semifailure" } }
          }
        },
        "Else" : {
          "SetContext" : { "Name" : "Result", "Value" : "Failure" }
        }
      }
    },
    {
      "If" : {
        "Left" : { "Use" : { "Value" : "True" } },
        "Condition" : "Equal",
        "Right" : {
          "Or" : { "Operands" : [
            {
              "In" : {
                "Test" : { "ReadContext" : { "Value" : "transaction.mcc" } },
                "Values" : [ 8211, 8220, 8241, 8244, 8249, 8299, 8351 ]
              }
            },
            {
              "And" : { "Operands" : [
                {
                  "In" : {
                    "Test" : { "ReadContext" : { "Value" : "transaction.mcc" } },
                    "Values" : [ 3900 ]
                  }
                },
                {
                  "In" : {
                    "Test" : { "ReadContext" : { "Value" : "transaction.merchantname" } },
                    "Values" : [ "yandex*8229*praktikum", "yandex*8299*uchebnik" ]
                  }
                }
              ] }
            },
            {
              "And" : { "Operands" : [
                {
                  "In" : {
                    "Test" : { "ReadContext" : { "Value" : "transaction.mcc" } },
                    "Values" : [ 3991 ]
                  }
                },
                {
                  "In" : {
                    "Test" : { "ReadContext" : { "Value" : "transaction.merchantname" } },
                    "Values" : [ "YANDEX*8299*ЕNGLISH", "SBER*8299*CampusSberUniver" ]
                  }
                }
              ] }
            }
          ] }
        },
        "Then" : {
          "SetContext" : { "Name" : "bonusTransaction", "Value" : "Bonus it" }
        }
      }
    },
    {
      "If" : {
        "Left" : { "ReadContext" : { "Value" : "bonusTransaction" } },
        "Condition" : "Equal",
        "Right" : { "Use" : { "Value" : "Bonus it" } },
        "Then" : {
          "SetCalcContext" : {
            "Name" : "bonusedAmount",
            "Value" : {
              "Divide" : {
                "Left": {
                  "Multiply" : { "Operands" : [
                    { "ReadContext" : { "Value" : "transactionAmount" } },
                    { "Use" : { "Value" : 150 } }
                  ] }
                },
                "Right" : { "Use" : { "Value" : 6000 } },
                "Round" : "Integer"
              }
            }
          }
        }
      }
    }
  ]
}
