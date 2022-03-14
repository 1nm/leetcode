import os

from slugify import slugify

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
    os.makedirs(f'problems/{slug}/java', exist_ok=True)
    os.makedirs(f'problems/{slug}/python', exist_ok=True)
