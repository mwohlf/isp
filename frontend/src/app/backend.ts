import {ModuleWithProviders} from "@angular/core";
import {ApiModule} from "../generated/api.module";
import {Configuration} from "../generated/configuration";


export function apiConfig() {
  return new Configuration({
    basePath: ' '
  });
}

export const Backend: ModuleWithProviders =  ApiModule.forRoot(apiConfig);

