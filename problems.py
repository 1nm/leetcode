from slugify import slugify
import os
from datetime import datetime


with open('problems.txt', 'r') as f:
  while True:
    title = f.readline()
    if not title:
      break
    title = title.rstrip()
    number, title = title.split('.')
    title = title.strip()
    accept_rate = f.readline().rstrip()
    difficulty = f.readline().rstrip()
    slug = slugify(f'{number}-{title}', lowercase=False)
    os.makedirs(f'problems/{slug}', exist_ok=True)
    with open(f'problems/{slug}/README.md', 'w') as fout:
      fout.write(f'# {number}. {title}\n')
      fout.write(f'- Difficulty: {difficulty}\n')
      fout.write(f'- Acceptance: {accept_rate} (as of {datetime.today().strftime("%Y-%m-%d")})\n')
    # print(f'{number},{title},{accept_rate},{difficulty}')