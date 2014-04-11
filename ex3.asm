;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE

facto:
;ouvbloc 0
enter 0,0
;iLoad
push word ptr [bp+4]

;iConst
push word ptr 1

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iConst
push word ptr 1

;ireturn 6
pop ax
mov [bp+6],ax

;goto FSI1
jmp FSI1

SINON1:
;iLoad
push word ptr [bp+4]

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+4]

;iConst
push word ptr 1

;isub
pop bx
pop ax
sub ax,bx
push ax

;call facto
call facto

;imul
pop bx
pop ax
imul bx
push ax

;ireturn 6
pop ax
mov [bp+6],ax

FSI1:

;fermebloc 2
leave
ret 2

combin:
;ouvbloc 6
enter 6,0
;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+6]

;call facto
call facto

;iStore
pop ax
mov word ptr [bp-2],ax

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+4]

;call facto
call facto

;iStore
pop ax
mov word ptr [bp-4],ax

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+6]

;iLoad
push word ptr [bp+4]

;isub
pop bx
pop ax
sub ax,bx
push ax

;call facto
call facto

;iStore
pop ax
mov word ptr [bp-6],ax

;iLoad
push word ptr [bp-2]

;iLoad
push word ptr [bp-4]

;iLoad
push word ptr [bp-6]

;imul
pop bx
pop ax
imul bx
push ax

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;ireturn 8
pop ax
mov [bp+8],ax

;fermebloc 4
leave
ret 4

arrang:
;ouvbloc 4
enter 4,0
;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+6]

;call facto
call facto

;iStore
pop ax
mov word ptr [bp-2],ax

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+4]

;call facto
call facto

;iStore
pop ax
mov word ptr [bp-4],ax

;iLoad
push word ptr [bp-2]

;iLoad
push word ptr [bp-4]

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;ireturn 8
pop ax
mov [bp+8],ax

;fermebloc 4
leave
ret 4

debut :
STARTUPCODE

main:
;ouvbloc 10
enter 10,0
;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-10],ax

FAIRE1:
;iLoad
push word ptr [bp-10]

;iConst
push word ptr 3

;idiff
pop bx
pop ax
cmp ax,bx
je $+6
push -1
jmp $+4
push 0

;iffaux FAIT1
pop ax
cmp ax,0
je FAIT1

;ecrireChaine
.DATA
mess0 DB " fact (0)arr (1),combi(2) ou sortie (3) ?$"
.CODE
lea dx,mess0
push dx
call ecrch

;lireEnt
lea dx,[bp-10]
push dx
call lirent

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-10]

;iConst
push word ptr 0

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

;ecrireChaine
.DATA
mess1 DB "n:$"
.CODE
lea dx,mess1
push dx
call ecrch

;goto FSI2
jmp FSI2

SINON2:
