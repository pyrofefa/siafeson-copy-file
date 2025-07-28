import { registerPlugin } from '@capacitor/core';

import type { CopyFileSiafesonPlugin } from './definitions';

const CopyFileSiafeson = registerPlugin<CopyFileSiafesonPlugin>('CopyFileSiafeson', {
  web: () => import('./web').then((m) => new m.CopyFileSiafesonWeb()),
});

export * from './definitions';
export { CopyFileSiafeson };
