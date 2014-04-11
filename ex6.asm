;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE

somdiv:
;ouvbloc 4
enter 4,0
;iConst
push word ptr 1

;iStore
pop ax
mov word ptr [bp-4],ax

;iConst
push word ptr 2

;iStore
pop ax
mov word ptr [bp-2],ax

FAIRE1:
;iLoad
push word ptr [bp-2]

;iLoad
push word ptr [bp+4]

;iConst
push word ptr 2

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

;iffaux FAIT1
pop ax
cmp ax,0
je FAIT1

;iLoad
push word ptr [bp+4]

;iLoad
push word ptr [bp-2]

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;iLoad
push word ptr [bp-2]

;imul
pop bx
pop ax
imul bx
push ax

;iLoad
push word ptr [bp+4]

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iLoad
push word ptr [bp-4]

;iLoad
push word ptr [bp-2]

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-4],ax

;goto FSI1
jmp FSI1

SINON1:
FSI1:

;iLoad
push word ptr [bp-2]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-2],ax

;goto FAIRE1
jmp FAIRE1

FAIT1:
;iLoad
push word ptr [bp-4]

;ireturn 6
pop ax
mov [bp+6],ax

;fermebloc 2
leave
ret 2

debut :
STARTUPCODE

main:
;ouvbloc 10
enter 10,0
;iConst
push word ptr 1

;iStore
pop ax
mov word ptr [bp-2],ax

FAIRE2:
;iLoad
push word ptr [bp-2]

;iConst
push word ptr 300

;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

;iffaux FAIT2
pop ax
cmp ax,0
je FAIT2

;iLoad
push word ptr [bp-2]

;iStore
pop ax
mov word ptr [bp-4],ax

FAIRE3:
;iLoad
push word ptr [bp-4]

;iConst
push word ptr 300

;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

;iffaux FAIT3
pop ax
cmp ax,0
je FAIT3

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp-2]

;call somdiv
call somdiv

;iStore
pop ax
mov word ptr [bp-6],ax

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp-4]

;call somdiv
call somdiv

;iStore
pop ax
mov word ptr [bp-8],ax

;iLoad
push word ptr [bp-6]

;iLoad
push word ptr [bp-4]

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iLoad
push word ptr [bp-8]

;iLoad
;iLoad
