# OOP_Final
## 架構 // 20151214
### Game
      // game class
### Functions
      // abstract class with nothing so far

### ActivityMenu // manipulate menu
      - menu // no use by far
      - CSDep // new a ConstructionDep object to use
      - MFDep // new a MunitionsFactory object to use
      - BKDep // new a Bank object

### Commander extends Camp 
      // to ask the distribution of the soldier
      
### ConstructionDep extends Functions // repair tower
      - fee       // fee per service
      - ser_name  // service name
      - ser_func  // function of this service 

### MunitionsFactory extends Functions // produce soldier
      - price           // price for add soildier
      - add_soldier     // the number of adding soldier

### Bank extends Functions
      // not yet finish
      
### Tower extends Camp
      - defense_soldier // total offensive soldier to the tower
      - point           // total point of earning
      - offense_soldier // total offensive soldier to the tower
      - blood           // remaining blood 
      
### Computer // compute the result of the round
      - a_off_death
      - b_off_death
      - a_def_death
      - b_def_death
      - a_loss_blood
      - b_loss_blood

## ----------------------------------------------------------------

## 架構 // 20151210
### tower
      - blood
      - defense_soldier
      - offense_soldier
      - blood
### player
      - num_soldier
      - money
      - player_name
      - Role role
            - role_id
            - role_name
            - Property prop
                  - // we can add role property here
