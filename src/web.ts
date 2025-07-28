import { WebPlugin } from '@capacitor/core';

import type { CopyFileSiafesonPlugin } from './definitions';

export class CopyFileSiafesonWeb extends WebPlugin implements CopyFileSiafesonPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
