import { environmment } from './enviroment.defaults';

export const environment = {
    ...environmment,

    production: true,
    log: false,
    flags: {
      useNewHeader: false
   }
}